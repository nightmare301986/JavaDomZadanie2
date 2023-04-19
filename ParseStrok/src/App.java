import java.io.*;

public class App {
    public class lib {
        // Считывание строк с файла
        public static String[] ReadLineFromFile(String pathway) throws Exception { //Используем BufferedReader
            BufferedReader br = new BufferedReader(new FileReader(pathway));
            String str;
            int size = 0;
            while ((str = br.readLine()) != null) {
                size += 1;
            }
            br.close();
            String[] listData = new String[size];
            int i = 0;
            BufferedReader br1 = new BufferedReader(new FileReader(pathway));
            while ((str = br1.readLine()) != null) {
                listData[i] = str;
                i += 1;
            }
            br1.close();
            return listData;

        }
    }

    public static void main(String[] args) throws Exception {               //Вывод сформированной записи (строк)
        String[] arrayData = lib.ReadLineFromFile("notes3.txt");
        for (int i = 0; i < arrayData.length; i++) {
            System.out.println(PrintLine(arrayData[i]));
        }

    }

    public static StringBuilder PrintLine(String line) {                    //Формируем строки с нужной записью элементов
        String line1 = line.replace("{", "");
        String line2 = line1.replace("}", "");
        String line3 = line2.replaceAll("\"", "");
        String line4 = line3.replace("[", "");
        String line5 = line4.replace("]", "");
        StringBuilder result = new StringBuilder("");
        String[] arrayData = line5.split(",");
        String[] listName = { "Студент ", " получил ", " по предмету " };
        for (int i = 0; i < arrayData.length; i++) {
            String[] arrData = arrayData[i].split(":");
            result.append(listName[i]);
            result.append(arrData[1]);
        }
        return result;
    }
}
