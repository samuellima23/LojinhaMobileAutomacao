package modulos.produto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import telas.LoginTela;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginTest {
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
    @DisplayName("Não é permitido logar com usuário inválido")
    @Test
    public void testValidarLoginComUsuarioInvalido(){
        String mensagemApresentada = new LoginTela(app)
                .informarOUsuario("teste")
                .informarASenha("teste")
                .submeterFormularioDeLoginInValido()
                .capturarMensagemApresentada();

        //Validar que a mensagem de valor invalido foi apresentada
        Assertions.assertEquals("Erro de autenticação",mensagemApresentada);
    }
    @DisplayName("é permitido logar com usuário válido")
    @Test
    public void testValidarLoginComUsuariovalido(){
        String mensagemApresentada = new LoginTela(app)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLoginValido()
                .capturarMensagemApresentada();

        //Validar que a tela de listagem de produtos foi apresentada
        Assertions.assertEquals("Lista de Produtos",mensagemApresentada);
    }
    @AfterEach
    public void afterEach(){
        app.quit();
    }
}
