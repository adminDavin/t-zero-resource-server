package com.t.zero.common.base.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class UUIDUtils {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", StringUtils.EMPTY);
	}
	
	public static String getUUIDTime() {
        return UUID.randomUUID().toString().split("-")[0];
    }
	
	public static String getStringRandom(int length) {
        List<Integer> val = new ArrayList<>(length);
        Random random = new Random();
        for (var i = 0; i < length; i++) {
            if (i == 0) {
                val.add(random.nextInt(9) + 1);
            } else {
                val.add(random.nextInt(10));
            }
        }
        return val.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
