package modulos.produto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import telas.LoginTela;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes mobile do modulo de produto")
public class ProdutoTest {
    private WebDriver app;

    @BeforeEach
    public void beforeEach() throws MalformedURLException {

        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("deviceName","emulator-5554");
        capacidades.setCapability("platformName","Android");
        capacidades.setCapability("app","C:\\Users\\samue\\Desktop\\Lojinha+Android+Nativa\\Lojinha Nativa\\lojinha-nativa.apk");


        this.app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capacidades);
        this.app.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @DisplayName("Não é permitido registrar produtos com valor igual a zero")
    @Test
    public void testValidacaoDoValorDeProdutoNaoPermitidoIgualAZero(){
        String mensagemApresentada = new LoginTela(app)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLoginValido()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Mesa")
                .informarValorDoProduto("000")
                .informarCorDoProduto("Amarelo e azul")
                .submeterOFormularioComErro()
                .capturarMensagemApresentada();

        //Validar que a mensagem de valor invalido foi apresentada
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentada);

    }
    @DisplayName("Não é permitido registrar produtos com valor maior que sete mil")
    @Test
    public void testValidacaoDoValorDeProdutoNaoPermitidoMaiorQueSeteMil(){
        String mensagemApresentada = new LoginTela(app)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLoginValido()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Mesa")
                .informarValorDoProduto("700001")
                .informarCorDoProduto("Amarelo e azul")
                .submeterOFormularioComErro()
                .capturarMensagemApresentada();

        //Validar que a mensagem de valor invalido foi apresentada
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentada);

    }
    @DisplayName("é permitido registrar produtos com valor igual a um centavo")
    @Test
    public void testValidacaoDoValorDeProdutoPermitidoIgualAUmCentavo(){
        String mensagemApresentada = new LoginTela(app)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLoginValido()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Mesa")
                .informarValorDoProduto("001")
                .informarCorDoProduto("Amarelo e azul")
                .submeterOFormularioComErro()
                .capturarMensagemApresentada();

        //Validar que a mensagem de valor valido foi apresentada
        Assertions.assertEquals("Produto adicionado com sucesso",mensagemApresentada);

    }
    @DisplayName("é permitido registrar produtos com valor igual a sete mil")
    @Test
    public void testValidacaoDoValorDeProdutoPermitidoIgualASeteMil(){
        String mensagemApresentada = new LoginTela(app)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLoginValido()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Mesa")
                .informarValorDoProduto("700000")
                .informarCorDoProduto("Amarelo e azul")
                .submeterOFormularioComErro()
                .capturarMensagemApresentada();

        //Validar que a mensagem de valor valido foi apresentada
        Assertions.assertEquals("Produto adicionado com sucesso",mensagemApresentada);

    }
    @AfterEach
    public void afterEach(){
    app.quit();
    }
}
