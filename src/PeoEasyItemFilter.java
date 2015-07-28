import javax.swing.JFileChooser;

public class PeoEasyItemFilter {
	
	public static String version = "0.1";

	public static void main(String[] args) {
		/*
		//Item Filter Testing
		String defaultFolder = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
		
		ItemFilter filt1 = new ItemFilter(defaultFolder + "\\My Games\\Path of Exile\\", "oftrta_muldini_v0.9m.filter");
		filt1.load();
		
		System.out.println(filt1.getItems().size());
		
		if(filt1.write("test")) System.out.println("Wrote the test file");
		*/
		
		//Gui Testing
		new Gui().launch(Gui.class);
	}
}
