package com.genericmethod.feedfire.sample;

import com.genericmethod.feedfire.cache.DataFireInMemoryCacheService;
import com.genericmethod.feedfire.event.DataFireEvent;
import com.genericmethod.feedfire.event.DataFireEventNotifier;
import com.genericmethod.feedfire.event.DataFireEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SampleEventNotifier extends DataFireEventNotifier<Sample,SampleEventType> {

  @Autowired
  private SampleCacheService sampleCacheService;
  @Autowired
  private SampleEventProducer sampleEventProducer;

  @Override
  public DataFireInMemoryCacheService getCacheService() {
    return sampleCacheService;
  }

  @Override
  public DataFireEventProducer getEventProducer() {
    return sampleEventProducer;
  }

  @Override
  public List<DataFireEvent<Sample, SampleEventType>> getEvent(Sample cachedObj, Sample feedObject) {
    return null;
  }

}
