Prerequisites of DP master recursion
Let's start with why we are moving dp
as we know if we are doing recursion we will repeat most of the steps again by traversing
so insteadof that we will store them one varible dp array / list intially -1 
whenever same one we will update the values and reuse it 
so because of this it will reduce time complexity for example 
take fibonaacci series => for recursion TC : O(2^n) SC = O(N) (stack space)
for dp TC : O(n) and sc = o(N)+o(N) => for array

Let's start with fibonacci recursion
  ---------------------------------

  f(n){
  if(n<=1) return n;
  return f(n-1)+f(n-2)
    }
Using DP
-------
int[] dp = new int[n+1];
Arrays.fill(dp,-1);
f(dp,n){
  f(int[] dp,int n){
  if(n<=1) return n;
  if(dp[n]!=-1) return dp[n];
  return dp[n]=dp[n-1]+dp[n-1];
}
