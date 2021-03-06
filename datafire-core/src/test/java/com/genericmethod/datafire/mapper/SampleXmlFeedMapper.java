package com.genericmethod.datafire.mapper;

import com.genericmethod.datafire.exception.DataFireException;
import com.genericmethod.datafire.sample.Sample;
import com.genericmethod.datafire.sample.SampleXml;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SampleXmlFeedMapper extends DataFireMapper<Sample> {

  private static final Logger LOG = Logger.getLogger(SampleXmlFeedMapper.class);

  @Override
  public List<Sample> mapToModel(String data) throws DataFireException {

    if (StringUtils.isBlank(data)) {
      throw new DataFireException("Xml feed cannot be null");
    }

    LOG.debug("Mapping retrieved event xml to Sample model objects.");
    XStream xStream = new XStream();
    xStream.processAnnotations(SampleXml.class);
    SampleXml sample = (SampleXml) xStream.fromXML(data);

    return sample.getSamples();
  }
}

