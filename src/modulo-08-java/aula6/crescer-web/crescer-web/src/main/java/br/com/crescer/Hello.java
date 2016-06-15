package br.com.crescer;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 * @author murillo.peteffi
 */

@ManagedBean
@ViewScoped
public class Hello implements Serializable {

    private String helloWorld = "Hello World!";

    public String getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }

}
