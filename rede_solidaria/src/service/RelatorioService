package service;

import java.io.FileOutputStream;
import java.io.IOException;
import model.*;
import repository.BancoDados;

public class RelatorioService {

    private void gerarPdf(String arquivo, String titulo, String conteudo) {
        try (FileOutputStream fos = new FileOutputStream(arquivo)) {
            String texto = titulo + "\n\n" + conteudo;

            String pdf =
                "%PDF-1.4\n" +
                "1 0 obj<< /Type /Catalog /Pages 2 0 R >>endobj\n" +
                "2 0 obj<< /Type /Pages /Kids [3 0 R] /Count 1 >>endobj\n" +
                "3 0 obj<< /Type /Page /Parent 2 0 R /MediaBox [0 0 612 792] /Contents 4 0 R /Resources<< /Font<< /F1 5 0 R >> >> >>endobj\n" +
                "4 0 obj<< /Length " + (texto.length() + 50) + " >>stream\nBT\n/F1 12 Tf\n50 750 Td\n(" +
                texto.replace("(", "[").replace(")", "]").replace("\n", ") Tj\n0 -15 Td\n(") +
                ") Tj\nET\nendstream\nendobj\n" +
                "5 0 obj<< /Type /Font /Subtype /Type1 /BaseFont /Helvetica >>endobj\n" +
                "xref\n0 6\n0000000000 65535 f \n" +
                "trailer<< /Root 1 0 R /Size 6 >>\nstartxref\n0\n%%EOF";

            fos.write(pdf.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gerarHistoricoDoacoesPDF() {
        StringBuilder sb = new StringBuilder();
        for(ItemDoacao i : BancoDados.itens) {
            sb.append(i.toString()).append("\n");
        }
        gerarPdf("historico_doacoes.pdf","HISTORICO DE DOACOES",sb.toString());
    }

    public void gerarItensEntreguesPDF() {
        StringBuilder sb = new StringBuilder();
        for(ItemDoacao i : BancoDados.itens) {
            if(i.getStatus() == StatusItem.ENTREGUE) {
                sb.append(i.toString()).append("\n");
            }
        }
        gerarPdf("itens_entregues.pdf","ITENS ENTREGUES",sb.toString());
    }

    public void gerarSolicitacoesPDF() {
        StringBuilder sb = new StringBuilder();
        for(Solicitacao s : BancoDados.solicitacoes) {
            sb.append(s.toString()).append("\n");
        }
        gerarPdf("solicitacoes.pdf","SOLICITACOES",sb.toString());
    }
}
