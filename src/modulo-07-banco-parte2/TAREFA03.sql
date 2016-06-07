create or replace package PCK_CONCURSO is

  procedure geraProximoConcurso;
  procedure atualizaAcertadores;

end PCK_CONCURSO;
/

create or replace package body PCK_CONCURSO is
  
    vIdUltimoConcurso CONCURSO.IDCONCURSO%type;
    vPremioSenaAnterior CONCURSO.PREMIO_SENA%type;
    vValorArrecadado CONCURSO.PREMIO_SENA%type;
    vDataUltimoConcurso CONCURSO.DATA_SORTEIO%type;
    vDataProximoConcurso CONCURSO.DATA_SORTEIO%type;
    vAcumulou CONCURSO.ACUMULOU%type;
       
    begin
    
    Select max(IDCONCURSO) 
    Into vIdUltimoConcurso 
    From CONCURSO;

    Select sum(VALOR) 
    Into vValorArrecadado 
    From APOSTA 
    Where IDCONCURSO = vIdUltimoConcurso;
    
    Select DATA_SORTEIO, ACUMULOU, PREMIO_SENA 
    Into vDataUltimoConcurso, vAcumulou, vPremioSenaAnterior 
    From CONCURSO 
    Where IDCONCURSO = vIdUltimoConcurso;
    
    If (TO_CHAR(vDataUltimoConcurso,'D') = 4) Then
      vDataProximoConcurso := vDataUltimoConcurso + 3;
    Elsif (TO_CHAR(vDataUltimoConcurso,'D') = 7) Then
      vDataProximoConcurso := vDataUltimoConcurso + 4;
    End if;
    
    If (vAcumulou = 0) THEN 
      vPremioBruto := vPremioBruto + vPremioSenaAnterior;
    END IF;
    
    PCK_MEGASENA.SALVACONCURSO(vIdUltimoConcurso+1, vDataProximoConcurso, vValorArrecadado * 0.453);
        
end;
  ----------------------------------------------------------------------

 
procedure atualizaAcertadores as

    CURSOR C_IDApostas IS Select APOSTA From ARQUIVO_APOSTA_A;
    CURSOR C_NumerosApostados (pID in number) IS Select NUMERO From NUMERO_APOSTA Where IDAPOSTA = pID;
    vAcertos number;
    n01 number; n02 number; n03 number; n04 number; n05 number; n06 number;

    begin      

    FOR ApostaUnica IN C_IDApostas LOOP 
      vAcertos := 0;

      Select PRIMEIRA_DEZENA, SEGUNDA_DEZENA, TERCEIRA_DEZENA, QUARTA_DEZENA, QUINTA_DEZENA, SEXTA_DEZENA
      Into n01, n02, n03, n04, n05, n06
      From CONCURSO
      Where IDCONCURSO = ApostaUnica.IDCONCURSO;
      
      FOR apostados IN C_NumerosApostados (ApostaUnica.APOSTA) LOOP
        IF apostados.numero in (n01, n02, n03, n04, n05, n06) THEN  vAcertos := vAcertos + 1; END IF;
      END LOOP;
      
      IF (vAcertos > 3) then 
        Insert Into APOSTA_PREMIADA (IDAPOSTA, ACERTOS, VALOR)
        Values(ApostaUnica.IDAPOSTA, vAcertos, ApostaUnica.VALOR);
      end if;

      IF (vAcertos = 6) then 
        Update CONCURSO
        Set ACUMULOU = 1
        Where IDCONCURSO = ApostaUnica.IDCONCURSO; 
      end if;
    END LOOP;

end;
  ----------------------------------------------------------------------

  
begin
  -- Initialization
  null;
end PCK_CONCURSO;
/