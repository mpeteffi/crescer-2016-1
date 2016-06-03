DECLARE 
  CURSOR C_IDApostas IS Select APOSTA From ARQUIVO_APOSTA_A;
  CURSOR C_NumerosApostados (pID in number) IS Select NUMERO From NUMERO_APOSTA Where IDAPOSTA = pID;
  vSena number; vQuina number; vQuadra number;
  vAcertos number;
  n01 number; n02 number; n03 number; n04 number; n05 number; n06 number;

BEGIN 
  vSena := 0; vQuina := 0; vQuadra := 0;
  
  Select PRIMEIRA_DEZENA, SEGUNDA_DEZENA, TERCEIRA_DEZENA, QUARTA_DEZENA, QUINTA_DEZENA, SEXTA_DEZENA
  Into n01, n02, n03, n04, n05, n06
  From CONCURSO
  Where IDCONCURSO = :pidConcurso;
    
    FOR ApostaUnica IN C_IDApostas LOOP 
      vAcertos := 0;
      
      FOR apostados IN C_NumerosApostados (ApostaUnica.APOSTA) LOOP
        IF apostados.numero in (n01, n02, n03, n04, n05, n06) THEN  vAcertos := vAcertos + 1; END IF;
      END LOOP;
      
      IF (vAcertos = 4) then vQuadra := vQuadra + 1; end if;
      IF (vAcertos = 5) then vQuina := vQuina + 1; end if;
      IF (vAcertos = 6) then vSena := vSena + 1; end if;
    END LOOP; 
  
  DBMS_OUTPUT.PUT_LINE('Sena: ' || vSena);
  DBMS_OUTPUT.PUT_LINE('Quina: ' || vQuina);
  DBMS_OUTPUT.PUT_LINE('Quadra ' || vQuadra);
END;