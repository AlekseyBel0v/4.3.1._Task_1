public class Main {

    public static void main(String[] args) {
        Installation installation = new Installation();
        String dirOfInstallation = "/Users" +
                                   "/belovaleksejolegovic" +
                                   "/Desktop/Нетология" +
                                   "/4. JAVA CORE" +
                                   "/4.3 Streams, files, serialisation" +
                                   "/4.3.1._Task_1" +
                                   "/Games";
        installation.createFile(dirOfInstallation,"src, res, savegames, temp");
        installation.createFile(dirOfInstallation + "/src","main, test");
        installation.createFile(dirOfInstallation + "/src/main","Main.java, Utils.java");
        installation.createFile(dirOfInstallation + "/res","drawables, vectors, icons");
        installation.createFile(dirOfInstallation + "/temp","temp.txt");
        System.out.println(Logs.logs);
    }
}