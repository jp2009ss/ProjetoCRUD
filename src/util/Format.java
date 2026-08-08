package util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Format {
    
    public static Date converterParaSqlDate(String dataTexto){
        //Define o formato recebido
        DateTimeFormatter formatoBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        //Converte String para LocalDate
        LocalDate data = LocalDate.parse(dataTexto, formatoBrasil);
        
        //Converte LocalDate para Date/SQL
        return Date.valueOf(data);
    }
    
    
    
}
    
    

