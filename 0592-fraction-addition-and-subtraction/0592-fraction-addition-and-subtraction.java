class Solution {

    public int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    int findlcm(List<Integer> arr, int n)
    {
    int ans = arr.get(0);
    for (int i = 1; i < n; i++)
        ans = (((arr.get(i) * ans)) /(gcd(arr.get(i), ans)));
 
    return ans;
    }
    public String fractionAddition(String expression) {
        List<Integer> nums = new ArrayList<>();
        List<Integer> dens = new ArrayList<>();

        int num = 0;
        int sign = 1;
        for(char c:expression.toCharArray()){
            if(c == '/'){
            nums.add(num * sign);
            num = 0;
            }
            else if(c == '+') {
            dens.add(num);   
            sign = 1;
            num = 0;
            }
            else if(c == '-'){
                if(num != 0)
                dens.add(num);
            sign = -1;
            num = 0;
            }
            else{
                num *= 10;
                num += (c-'0');
            }
        }

        dens.add(num);

        int n  = dens.size();
        int lcm = findlcm(dens, n);

        int f_num = 0;

        for(int i = 0; i < n; i++){
            int v = nums.get(i) * (lcm/dens.get(i));
            f_num += v;
        }

        int fct = Math.abs(gcd(f_num, (int)lcm));

        String ans = "";
        ans += Integer.toString(f_num/fct);
        ans += '/';
        ans += Integer.toString(lcm/fct);
        return ans;
    }
}