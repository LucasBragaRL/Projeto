package configExcel;

import lombok.extern.slf4j.Slf4j;
import usuario.Usuario;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class CriaArquivoExcel {

    public void criarArquivo(final String nomeArquivo, final Usuario usuario) {
        System.out.println("inciando cadastro" );

        try (var workbook = new XSSFWorkbook();
             var outputStream = new FileOutputStream(nomeArquivo)) {

            var planilha = workbook.createSheet("Lista de Usuarios");
            int numeroDaLinha = 0;

            adicionarCabecalho(planilha, numeroDaLinha++);

            // Adiciona apenas o único usuário
            var linha = planilha.createRow(numeroDaLinha++);
            adicionarCelula(linha, 0, usuario.getId());
            adicionarCelula(linha, 1, usuario.getNome());
            adicionarCelula(linha, 2, usuario.getEmail());
            adicionarCelula(linha, 3, usuario.getSenha());

            workbook.write(outputStream);
            System.out.println("Usuario cadastrado com sucesso!");

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + nomeArquivo);
        }
    }

    private void adicionarCabecalho(XSSFSheet planilha, int numeroLinha) {
        var linha = planilha.createRow(numeroLinha);
        adicionarCelula(linha, 0, "Id");
        adicionarCelula(linha, 1, "Nome");
        adicionarCelula(linha, 2, "Email");
        adicionarCelula(linha, 3, "Senha");
    }

    private void adicionarCelula(Row linha, int coluna, String valor) {
        Cell cell = linha.createCell(coluna);
        cell.setCellValue(valor);
    }

    private void adicionarCelula(Row linha, int coluna, int valor) {
        Cell cell = linha.createCell(coluna);
        cell.setCellValue(valor);
    }
}
