import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Installation {
    void createFile(String PathForParentDir, String files) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        File parentDir = new File(PathForParentDir);
        try {
            if (!parentDir.exists()) {
                throw new FileNotFoundException('\n' +
                                                sdf.format(new Date()) + '\n'
                                                + " Файлы/директории: " + files + " не созданы!" + '\n'
                                                + " Некорректный адрес: " + PathForParentDir + '\n');
            }
            Arrays.stream(files.split(", ")).forEach(x -> {
                try {
                    if (x.contains(".")) {
                        if (new File(parentDir, x).createNewFile()) {
                            Logs.logs.append('\n' +
                                             sdf.format(new Date()) + '\n' +
                                             " Файл " + x + " создан по адресу:" + '\n' +
                                             PathForParentDir + '\n');
                        } else {
                            Logs.logs.append('\n' +
                                             sdf.format(new Date()) + '\n' +
                                             " Файл " + x + " не создан!" + '\n');
                        }
                    } else {
                        if (new File(parentDir + "/" + x).mkdir()) {
                            Logs.logs.append('\n' +
                                             sdf.format(new Date()) + '\n' +
                                             " Директория " + x + " создана по адресу:" + '\n' +
                                             PathForParentDir + '\n');
                        } else {
                            Logs.logs.append('\n' +
                                             sdf.format(new Date()) + '\n' +
                                             " Директория " + x + " не создана!" + '\n');
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (FileNotFoundException e) {
            Logs.logs.append('\n' + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users" +
                                                                       "/belovaleksejolegovic" +
                                                                       "/Desktop/Нетология" +
                                                                       "/4. JAVA CORE" +
                                                                       "/4.3 Streams, files, serialisation" +
                                                                       "/4.3.1._Task_1" +
                                                                       "/Games" +
                                                                       "/temp/temp.txt", false))) {
            writer.write(Logs.logs.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
