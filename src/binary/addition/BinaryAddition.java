/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.addition;

/**
 *
 * @author Duane
 */
public class BinaryAddition {
    
    public static int binaryToDecimal(int number) {
        int decimal = 0;
        int binary = number;
        int power = 0;

        while (binary != 0) {
            int lastDigit = binary % 10;
            decimal += lastDigit * Math.pow(2, power);
            power++;
            binary = binary / 10;
        }
        System.out.println("Decimal value: "+decimal);
        return decimal;
    }
    
    public static String binaryAddition(String s1, String s2) {
    if (s1 == null || s2 == null) return "";
    if (s1.charAt(0)=='0'){s1=s1.substring(1);}
    if (s1.charAt(0)=='1'){s1="-"+s1.substring(1);}
    if (s2.charAt(0)=='0'){s2=s2.substring(1);}
    if (s2.charAt(0)=='1'){s2="-"+s2.substring(1);}
    int first = s1.length() - 1;
    int second = s2.length() - 1;
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    while (first >= 0 || second >= 0) {
        int sum = carry;
        if (first >= 0) {
            sum += s1.charAt(first) - '0';
            first--;
        }
        if (second >= 0) {
            sum += s2.charAt(second) - '0';
            second--;
        }
        carry = sum >> 1;
        sum = sum & 1;
        sb.append(sum == 0 ? '0' : '1');
    }
    if (carry > 0)
        sb.append('1');

    sb.reverse();
    String a=String.valueOf(sb);
    System.out.println("Addition: "+a);
    int b= Integer.parseInt(a);
    binaryToDecimal(b);
    return String.valueOf(sb);
}
    public String diff(String st1,String st2)
    {
        String nst="",max="";char b='0';boolean tf=(st1.length()>=st2.length());
        int l1=st1.length(),l2=st2.length();
        if(l1<l2)
        for(int a=1;a<=l2-l1;a++)
        st1='0'+st1;

        else if(l2<l1)
        for(int a=1;a<=l1-l2;a++)
        st2="0"+st2;
        if(!tf)for(int a=l1-1;a>=0;a--)
        if(st1.charAt(a)!=st2.charAt(a))
        if(st2.charAt(a)=='1'){max=st2;st2=st1;st1=max;break;}

        for(int a=st1.length()-1;a>=0;a--)
        {
            if(st1.charAt(a)=='1' && st2.charAt(a)=='0')
            {
                if(b=='1')
                {nst='0'+nst;b='0';}
                else
                nst='1'+nst;
            }

            else if(st1.charAt(a)==st2.charAt(a) && st2.charAt(a)=='1')
            {
                if(b=='1')
               {nst='1'+nst;b='1';}
                else
                nst='0'+nst;
            }

            else if(st1.charAt(a)=='0' && st2.charAt(a)=='1')
            {
                if(b=='1')
                nst='0'+nst;
                else
                {nst='1'+nst;b='1';}
            }

            else
            {
                if(b=='1')
                nst='1'+nst;
                else
                nst='0'+nst;
            }
        }
        System.out.println("Subtraction: "+ nst);
        int o= Integer.parseInt(nst);
        binaryToDecimal(o);
        return nst;
    }

public static int binaryproduct(int binary1, int binary2) 
 {
  int i = 0, remainder = 0;
  int[] sum = new int[20];
  int binary_prod_result = 0;

  while (binary1 != 0 || binary2 != 0) 
  {
   sum[i++] = (binary1 % 10 + binary2 % 10 + remainder) % 2;
   remainder = (binary1 % 10 + binary2 % 10 + remainder) / 2;
   binary1 = binary1 / 10;
   binary2 = binary2 / 10;
  }
  if (remainder != 0)
  {
   sum[i++] = remainder;
  }
  --i;
  while (i >= 0) 
  {
   binary_prod_result = binary_prod_result * 10 + sum[i--];
  }
  return binary_prod_result;
 }

    
    public static void main(String[] args){
        BinaryAddition obj= new BinaryAddition();
        obj.binaryAddition("00000000000000000000000000101011","11111111111111111111111111111101");
        obj.diff("00000000000000000000000000101011","11111111111111111111111111111101");
    }
}
