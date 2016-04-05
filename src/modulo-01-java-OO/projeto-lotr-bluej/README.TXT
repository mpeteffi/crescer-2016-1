// ANTES
public atirarFlechaRefactory(this.flechas, this.experiencia){
    if(boolean acertar == true){
        flechas--;
        experiencia++;
    }else{
        flechas--;
    }
}

// DEPOIS
// OBS: acertar no escopo abaixo é inútil.
public void atirarFlechaRefactory() {
    experiencia++;
    flechas--;
}









