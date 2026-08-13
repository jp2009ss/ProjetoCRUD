package util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Format {

    public static Date converterParaSqlDate(String dataTexto) {
        //Define o formato recebido
        DateTimeFormatter formatoBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Converte String para LocalDate
        LocalDate data = LocalDate.parse(dataTexto, formatoBrasil);

        //Converte LocalDate para Date/SQL
        return Date.valueOf(data);
    }

    // Verifica se o texto possui algum número
    public static boolean temNumero(String texto) {
        return texto.matches(".*\\d.*");
    }

    // VALIDAR E-MAIL
    public static boolean emailValido(String email) {

        // Verifica um formato básico:
        // texto@texto.extensao
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    // VALIDAR CPF
    public static boolean cpfValido(String cpf) {

        // Remove pontos e traço
        cpf = cpf.replace(".", "").replace("-", "");

        // Verifica se possui exatamente 11 números
        if (!cpf.matches("\\d{11}")) {
            return false;
        }

        // Impede CPFs com todos os números iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;

        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }

        int digito1 = 11 - (soma % 11);

        if (digito1 >= 10) {
            digito1 = 0;
        }

        // Calcula o segundo dígito verificador
        soma = 0;

        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }

        int digito2 = 11 - (soma % 11);

        if (digito2 >= 10) {
            digito2 = 0;
        }

        // Compara os dígitos calculados com os informados
        return digito1 == Character.getNumericValue(cpf.charAt(9))
                && digito2 == Character.getNumericValue(cpf.charAt(10));
    }

    public static String dateParaString(String data) {
        LocalDate dataConvertida = LocalDate.parse(data); // Converte o texto do banco para uma data
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");// Define o formato brasileiro
        return dataConvertida.format(formato);    // Retorna a data formatada
    }
}
