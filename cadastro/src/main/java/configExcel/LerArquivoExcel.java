package configExcel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class LerArquivoExcel {

    public boolean verificarCredenciais(final String nomeArquivo, final String email, final String senha) {

        if (email == null || email.trim().isEmpty() || senha == null || senha.trim().isEmpty()) {
            System.out.println("Aviso: Email ou senha vazios ou nulos");
            return false;
        }

        try (FileInputStream excelFile = new FileInputStream(nomeArquivo);
             XSSFWorkbook workbook = new XSSFWorkbook(excelFile)) {

            Sheet primeiraAba = workbook.getSheetAt(0);

            if (primeiraAba.getPhysicalNumberOfRows() <= 1) {
                System.out.println("Aviso: Planilha vazia ou apenas com cabeçalho: " + nomeArquivo);
                return false;
            }

            int contadorLinha = 0;
            for (Row linha : primeiraAba) {
                contadorLinha++;
                if (contadorLinha == 1) continue; // Pula cabeçalho

                // Garantir que a linha tem pelo menos 4 colunas
                if (linha.getPhysicalNumberOfCells() < 4) continue;

                // Pega o e-mail e a senha da MESMA linha
                String emailNaLinha = getSafeStringValue(linha.getCell(2)).trim();
                String senhaNaLinha = getSafeStringValue(linha.getCell(3)).trim();

                // Verifica se ambos coincidem com os dados fornecidos
                if (email.equalsIgnoreCase(emailNaLinha) && senha.equals(senhaNaLinha)) {
                    System.out.println("Usuário e senha correspondem na linha " + contadorLinha);
                    return true; // Encontrou o usuário correto
                }
            }

        } catch (IOException e) {
            System.err.println("Erro de I/O ao processar arquivo: " + nomeArquivo);
            e.printStackTrace();
        }

        System.out.println("Credenciais não encontradas ou inválidas");
        return false;
    }

    private String getSafeStringValue(org.apache.poi.ss.usermodel.Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue();
            case NUMERIC: 
                double value = cell.getNumericCellValue();
                if (value == (int) value) return String.valueOf((int) value);
                return String.valueOf(value);
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                try { return cell.getStringCellValue(); }
                catch (Exception e) { return String.valueOf(cell.getNumericCellValue()); }
            default: return "";
        }
    }
}
