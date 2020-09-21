package org.buoi2;

import org.junit.Test;

import javax.xml.transform.sax.SAXSource;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Bai3 {
    @Test
    public void shouldAnswerWithTrue() {
        int mangSoNguyen[] = {1, 2, 6, 3, 4, 2};
        ArrayList<Integer> mangMongMuon = new ArrayList<>();
        mangMongMuon.add(2);
        mangMongMuon.add(3);
        mangMongMuon.add(2);
        ArrayList<Integer> mangThucTe = listSoNguyenTo(mangSoNguyen);
        System.out.println("mang so nguyen size" + mangMongMuon.size());
        for (int i = 0; i < mangMongMuon.size(); i++) {
            System.out.println("i"+i);
            assertEquals(mangMongMuon.get(i).intValue(), mangThucTe.get(i).intValue());
        }
    }

    public static ArrayList<Integer> listSoNguyenTo(int mangSoNguyen[]) {
        ArrayList<Integer> mangTraVe = new ArrayList<>();
        for (int i = 0; i < mangSoNguyen.length; i++) {
            if (isPrime(mangSoNguyen[i]) == true) {
                mangTraVe.add(mangSoNguyen[i]);
            }
        }
        return mangTraVe;

    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
