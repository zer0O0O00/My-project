import java.io.File;
import java.io.IOException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.util.Scanner;
import static java.nio.file.Paths.*;
import java.util.Random;

public class GenerateQRcode {
    public static void main(String[] args) throws IOException, WriterException {


        // Создание папки
        File dir = new File("C:\\QRcode");
        if (!dir.exists()) {
            boolean success = dir.mkdir();
            System.out.println("Путь успешно задан");
        }

        // Задаём путь и текс
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите то что хотите преобразовать в QRcode: ");
        String data = scanner.nextLine();

        Random random = new Random();
        int randomNumber = random.nextInt(101);
        int count_QR = randomNumber;
        String path = "C:\\QRcode\\qrcode" + count_QR + ".jpg";

        // Создание
        BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 500, 500);
        MatrixToImageWriter.writeToPath(matrix, "jpg", get(path));
        System.out.println("QRcode успешно создан \nПуть: " + path);
    }
}
