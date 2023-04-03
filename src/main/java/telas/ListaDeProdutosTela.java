package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosTela extends BaseTela {
    public ListaDeProdutosTela(WebDriver app){
        super(app);
    }

    public FormularioDeAdicaoDeProdutosTela acessarOFormularioDeAdicaoDeNovoProduto(){
        //Abrir formulario de novo produto
        app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();

        return new FormularioDeAdicaoDeProdutosTela(app);
    }
    public String capturarMensagemApresentada(){
        return app.findElement(By.id("com.lojinha:id/appBarLayout")).findElement(By.id("com.lojinha:id/appToolbar")).findElement(By.xpath("//android.widget.TextView")).getText();
    }
}
