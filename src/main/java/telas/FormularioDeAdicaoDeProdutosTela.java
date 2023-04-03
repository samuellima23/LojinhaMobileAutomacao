package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdicaoDeProdutosTela extends BaseTela {
    public FormularioDeAdicaoDeProdutosTela(WebDriver app){
        super(app);
    }

    public FormularioDeAdicaoDeProdutosTela informarNomeDoProduto(String produtoNome){
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoNome);

        return this;
    }
    public FormularioDeAdicaoDeProdutosTela informarValorDoProduto(String produtoValor){
        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoValor);

        return this;
    }
    public FormularioDeAdicaoDeProdutosTela informarCorDoProduto(String produtoCor){
        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoCor);

        return this;
    }

    public FormularioDeAdicaoDeProdutosTela submeterOFormularioComErro(){
        app.findElement(By.id("com.lojinha:id/saveButton")).findElement(By.id("com.lojinha:id/button")).click();

        return new FormularioDeAdicaoDeProdutosTela(app);
    }
    public String capturarMensagemApresentada(){
        return capturarToast();
    }
}
