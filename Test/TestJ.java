import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestJ {

	@Test
	public void testConnexionUser() {
		Assert.assertTrue("Connexion �chou�e", Modele.connecter("test", "test"));
	}

}
