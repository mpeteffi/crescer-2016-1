DECLARE 
	CURSOR C_ListaApostas IS Select * From ARQUIVO_APOSTA_A;
  vQuadra number;
  vQuina number;
  vSena number;
  vAcertos number;

BEGIN 
  vQuina := 0;
  vSena := 0;
  vQuadra := 0;
    
	FOR aposta IN C_ListaApostas LOOP 
    vAcertos := 0;
    
		IF aposta.n1 in (5, 10, 12, 22, 28, 48) THEN  vAcertos := vAcertos + 1; END IF;
    IF aposta.n2 in (5, 10, 12, 22, 28, 48) THEN  vAcertos := vAcertos + 1; END IF;
    IF aposta.n3 in (5, 10, 12, 22, 28, 48) THEN  vAcertos := vAcertos + 1; END IF;
    IF aposta.n4 in (5, 10, 12, 22, 28, 48) THEN  vAcertos := vAcertos + 1; END IF;
    IF aposta.n5 in (5, 10, 12, 22, 28, 48) THEN  vAcertos := vAcertos + 1; END IF;
    IF aposta.n6 in (5, 10, 12, 22, 28, 48) THEN  vAcertos := vAcertos + 1; END IF;
    IF aposta.n7 in (5, 10, 12, 22, 28, 48) THEN  vAcertos := vAcertos + 1; END IF;
    IF aposta.n8 in (5, 10, 12, 22, 28, 48) THEN  vAcertos := vAcertos + 1; END IF;
    IF aposta.n9 in (5, 10, 12, 22, 28, 48) THEN  vAcertos := vAcertos + 1; END IF;
    IF aposta.n10 in (5, 10, 12, 22, 28, 48) THEN  vAcertos := vAcertos + 1; END IF;
    IF aposta.n11 in (5, 10, 12, 22, 28, 48) THEN  vAcertos := vAcertos + 1; END IF;
    IF aposta.n12 in (5, 10, 12, 22, 28, 48) THEN  vAcertos := vAcertos + 1; END IF;
    IF aposta.n13 in (5, 10, 12, 22, 28, 48) THEN  vAcertos := vAcertos + 1; END IF;
    IF aposta.n14 in (5, 10, 12, 22, 28, 48) THEN  vAcertos := vAcertos + 1; END IF;
    IF aposta.n15 in (5, 10, 12, 22, 28, 48) THEN  vAcertos := vAcertos + 1; END IF;
    
    IF (vAcertos = 4) then vQuadra := vQuadra + 1; end if;
    IF (vAcertos = 5) then vQuina := vQuina + 1; end if;
    IF (vAcertos = 6) then vSena := vSena + 1; end if;
	END LOOP; 
  
  DBMS_OUTPUT.PUT_LINE('Sena: ' || vSena);
  DBMS_OUTPUT.PUT_LINE('Quina: ' || vQuina);
  DBMS_OUTPUT.PUT_LINE('Quadra ' || vQuadra);
END;