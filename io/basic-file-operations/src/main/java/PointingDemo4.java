import java.io.File;

public class PointingDemo4 {

    public static void main(String[] args) {
        String os = System.getProperty("os.name");
        File rootPath = null;
        if (os.toLowerCase().contains("windows")){
            System.out.println("Windows OS");
            for (File root : File.listRoots()) {
                File windowsDir = new File(root, "Windows");
                if (windowsDir.exists()){
                    rootPath = root;
                    break;
                }
            }
        }else{
            System.out.println("Unix-like OS");
            rootPath = File.listRoots()[0];
        }
        File pointer = new File(new File(new File(rootPath, "opt"), "java"), "21");
        System.out.println(pointer);
    }
}
