package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTela extends BaseTela {
    public LoginTela(WebDriver app){
        super(app);
    }

    public LoginTela informarOUsuario(String usuario){
        //Fazer Login
        app.findElement(By.id("com.lojinha:id/user")).click();
        app.findElement(By.id("com.lojinha:id/user")).findElement(By.id("com.lojinha:id/editText")).sendKeys(usuario);

        return this;
    }
    public LoginTela informarASenha(String senha){
        //Fazer Login
        app.findElement(By.id("com.lojinha:id/password")).click();
        app.findElement(By.id("com.lojinha:id/password")).findElement(By.id("com.lojinha:id/editText")).sendKeys(senha);

        return this;
    }
    public ListaDeProdutosTela submeterFormularioDeLoginValido(){

        app.findElement(By.id("com.lojinha:id/loginButton")).click();

        return new ListaDeProdutosTela(app);
    }
    public LoginTela submeterFormularioDeLoginInValido(){

        app.findElement(By.id("com.lojinha:id/loginButton")).click();

        return this;
    }
    public String capturarMensagemApresentada(){
        return capturarToast();
    }
}
