package org.buoi2;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.transform.sax.SAXSource;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Bai3 {
    Bai3Method bai3Method = new Bai3Method();

    @Test
    public void happyCase() {
        Integer listInteger[] = {1, 2, 6, 3, 4, 2};
        Integer expectedResult[] = {2, 3, 2};
        Object actualResult[] = bai3Method.listSoNguyenTo(listInteger).toArray();
        Assert.assertArrayEquals(actualResult, expectedResult);
    }

    @Test
    public void exceptionCase() {
        Integer listInteger[] = {4, 6, 8, 10};
        Integer expectedResult[] = {};
        Object actualResult[] = bai3Method.listSoNguyenTo(listInteger).toArray();
        Assert.assertArrayEquals(actualResult, expectedResult);
    }


}
