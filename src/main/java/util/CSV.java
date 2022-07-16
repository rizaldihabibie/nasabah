package util;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import model.DataBefore;

import java.io.FileReader;
import java.util.List;

public class CSV {
    public List<DataBefore> convertToObject(FileReader fileReader){
        List<DataBefore> listDataBefore = new CsvToBeanBuilder(fileReader)
                .withSeparator(';')
                .withType(DataBefore.class)
                .withSkipLines(1)           // skip the first line, header info
                .build()
                .parse();
        return listDataBefore;
    }
}
