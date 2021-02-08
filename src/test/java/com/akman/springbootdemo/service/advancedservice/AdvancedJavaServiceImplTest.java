package com.akman.springbootdemo.service.advancedservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AdvancedJavaServiceImpl.class)
public class AdvancedJavaServiceImplTest {

    @InjectMocks
    private AdvancedJavaServiceImpl advancedJavaService;

    @Test
    public void test() {

    }
}