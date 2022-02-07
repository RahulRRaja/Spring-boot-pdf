package com.example.Spring.boot.Pdf.helper;

import com.example.Spring.boot.Pdf.entity.User;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class UserExporter {

        private List<User> userList;

        public UserExporter(List<User> userList) {
            this.userList = userList;
        }


        public void writeTableHeader(PdfPTable table) {
            PdfPCell cell = new PdfPCell();
            cell.setBorderColor(Color.blue);
            cell.setPadding(5);

            Font font = FontFactory.getFont(FontFactory.HELVETICA);
            font.setColor(Color.BLACK);

            cell.setPhrase(new Phrase("id", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase("user_name", font));
            table.addCell(cell);


            cell.setPhrase(new Phrase("address", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase("age", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase("city", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("phone_no", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("email", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("first_name", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("last_name", font));
            table.addCell(cell);
        }

        private void writeTableData(PdfPTable table) {
            for (User user : userList) {
                table.addCell(String.valueOf(user.getId()));
                table.addCell(user.getUser_name());
                table.addCell(user.getAddress());
                table.addCell(String.valueOf(user.getAge()));
                table.addCell(user.getCity());
                table.addCell(user.getPhone_no());
                table.addCell(user.getEmail());
                table.addCell(user.getFirst_name());
                table.addCell(user.getLast_name());
            }
        }

        public void export(HttpServletResponse response) throws DocumentException, IOException {

            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            font.setSize(20);
            font.setColor(Color.blue);

            Paragraph p = new Paragraph("List Of Users", font);
            p.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(p);

            PdfPTable table = new PdfPTable(9);
            table.setWidthPercentage(100f);
            table.setWidths(new float[]{1.5f, 3.5f, 4.5f, 3.0f, 3.0f, 3.5f, 3.5f, 3.5f, 4.0f});
            table.setSpacingBefore(10);

            writeTableHeader(table);
            writeTableData(table);

            document.add(table);
            document.close();
        }
    }
