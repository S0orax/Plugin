package plugins;

public class MookPlugin implements Plugin {

	@Override
	public String transform(String s) {
		return "Test";
	}

	@Override
	public String getLabel() {
		return "MookPlugin";
	}

}
