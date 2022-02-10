package perscholas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import lombok.extern.slf4j.Slf4j;



@Configuration
public class UploadConfig {

    @Value("${fileUpload.maxFileSize}")
    private String maxFileSize;

    @Bean
    public CommonsMultipartResolver commonsMultipartResolver(){

      //  long bytes = DataSize.parse(maxFileSize).toBytes();
      //  log.debug("Maximum file size upload is ")

        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSizePerFile(DataSize.parse(maxFileSize).toBytes());

        return commonsMultipartResolver;

    }
}
