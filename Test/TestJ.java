import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestJ {

	@Test
	public void testConnexionUser() {
		Assert.assertTrue("Connexion échouée", Modele.connecter("test", "test"));
	}

}
