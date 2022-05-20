package com.t.zero.res.c.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ScoreTests {
	public List<String> stm = new ArrayList<>();
	public List<String> tb = new ArrayList<>();
	public Integer eFlag = 0;
	public String cTb = "";
	public Integer b = 0;
	
	private boolean handleInput(Scanner scan) {
		var message = scan.nextLine();
		var ms = message.split(" ");
		var event = Integer.valueOf(ms[0]);
		var continueFlag = true;
		cTb = "";
		switch (event) {
		case 1:
			stm.add(message.replace("1 ", ""));
			break;
		case 2:
			cTb = message.replace("2 ", "");
			tb.add(message.replace("2 ", ""));
			eFlag = eFlag - stm.size() + 1;
			break;
		case 3:
			continueFlag = false;
			break;
		default:
			System.out.println("nothing to do");
		}
		return continueFlag;
	}
	
	@Test
	public void main() {
		ObjectMapper mapper = new ObjectMapper();
		Random random = new Random(System.currentTimeMillis());
		try (Scanner scan = new Scanner(System.in)) {
			var message = scan.nextLine();
			var ms = message.split(" ");
			var l = Integer.valueOf(ms[0]);
			eFlag = Integer.valueOf(ms[1]);
			List<Integer> li = new ArrayList<>(l);
			var i = 0l;
			while (i < l) {
				i++;
				li.add(random.nextInt(10));
			}
			System.out.println(mapper.convertValue(li, JsonNode.class));
			var tn = 0;
			double score = 0;
			while (handleInput(scan) && tn < l) {
				List<Integer> temp = stm.stream().map(it -> Integer.valueOf(it.length())).sorted().collect(Collectors.toList());
//				System.out.println("-------------------------------------------------------------------------------");
//				System.out.println("stm 数组中各元素长度: " + String.join(",", temp.stream().map(String::valueOf).toArray(String[]:: new)));
//				System.out.println("tb 数组元素: " + String.join(",", tb.stream().toArray(String[]:: new)));
				
				for(var it: stm) {
					if (cTb.equals(it)) {
						b++;
					}
				}
//				System.out.println("b = " + b);
				var len = temp.size();
				var a = len % 2 == 0 ? (double)temp.get(len/2 - 1): (double)(temp.get(len/2));
//				System.out.println("影响值" + eFlag + ", a=" + a);
				score = score + a * b * li.get(tn);
				tn++;
			}
			
			System.out.println("结束..............................");
			System.out.println("b = " + b);
			System.out.println("score = " + score);
		}

	}

	
}
