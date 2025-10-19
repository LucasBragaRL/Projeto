package configExcel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import usuario.Usuario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class AdicionarClientesExcel {

    public void adicionarClientes(String arquivoExcel, List<Usuario> novoUsuario) {
        try {
            Workbook workbook;
            
            // Tentar abrir arquivo existente ou criar novo
            try {
                FileInputStream input = new FileInputStream(arquivoExcel);
                workbook = new XSSFWorkbook(input);
                input.close();
            } catch (IOException e) {
                workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Usuarios");
                // Criar cabeçalho
                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("ID");
                header.createCell(1).setCellValue("Nome");
                header.createCell(2).setCellValue("Email");
                header.createCell(3).setCellValue("Senha");
            }
            
            Sheet sheet = workbook.getSheetAt(0);
            
            // Encontrar próxima linha vazia
            int nextRow = sheet.getLastRowNum() + 1;
            if (nextRow == 1 && sheet.getRow(0) != null) {
                nextRow = 1; // Começar após o cabeçalho
            }
            
            // Adicionar clientes
            for (Usuario usuario : novoUsuario) {
                Row row = sheet.createRow(nextRow++);
                row.createCell(0).setCellValue(usuario.getId());
                row.createCell(1).setCellValue(usuario.getNome());
                row.createCell(2).setCellValue(usuario.getEmail());
                row.createCell(3).setCellValue(usuario.getSenha());
            }
            
            // Salvar
            FileOutputStream output = new FileOutputStream(arquivoExcel);
            workbook.write(output);
            workbook.close();
            output.close();
            
            System.out.println(novoUsuario.size() + " Usuario adicionados com sucesso!");
            
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    // Método para adicionar um único cliente
    public void adicionarCliente(String arquivoExcel, Usuario usuario) {
        adicionarClientes(arquivoExcel, List.of(usuario));
    }
}