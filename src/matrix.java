public class matrix {
    private complex[][] matr;
    private int n,m;
    matrix(int n,int m){
        this.n=n;
        this.m=m;
        matr=new complex[n][m];
        for (int i = 0; i<n; i++){
            for (int j=0;j<m;j++){
                matr[i][j]=new complex(0,0);
            }
        }
    }
    public int getN(){return n;}
    public int getM(){return m;}
    public complex getMatr(int x, int y){
        return matr[x][y];
    }
    public void setMatr(int x, int y, complex value){
        matr[x][y]=value;
    }
    public matrix summarise(matrix mat){
        if (this.n!=mat.n || this.m!=mat.m){
            throw new IllegalArgumentException("Error. These matrices are of different sizes");
        }
        else {
            matrix res = new matrix(n, m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    complex x1 = this.getMatr(i, j);
                    complex x2 = mat.getMatr(i, j);
                    res.setMatr(i, j, x1.add(x2));
                }
            }
            return res;
        }
    }
    public matrix subtraction(matrix mat){
        if (this.n!=mat.n || this.m!=mat.m){
            throw new IllegalArgumentException("Error. These matrices are of different sizes");
        }
        else{
            matrix res=new matrix(n,m);
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    complex x1=this.getMatr(i, j);
                    complex x2=mat.getMatr(i, j);
                    res.setMatr(i,j,x1.subtract(x2));
                }
            }
            return res;
        }
    }
    public matrix multiplication(matrix mat){
        if (this.m!=mat.n){
            throw new IllegalArgumentException("Error. These matrices are of different sizes");
        }
        else{
            int newn=this.n;
            int newm=mat.m;
            matrix res=new matrix(newn,newm);
            for (int i=0;i<newn;i++){
                for (int j=0;j<newm;j++){
                    complex sum=new complex(0,0);
                    for (int k=0;k<this.m;k++){
                        complex x1=this.getMatr(i, k);
                        complex x2=mat.getMatr(k, j);
                        sum=sum.add(x1.multiply(x2));
                    }
                    res.setMatr(i,j,sum);
                }
            }
            return res;
        }
    }
    public matrix transp(){
        matrix res=new matrix(m,n);
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                complex x1=this.getMatr(i, j);
                res.setMatr(j,i,x1);
            }
        }
        return res;
    }

    public String printInfo(){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(matr[i][j].printI()).append("  ");
            }
            sb.append("\n");
        }
        String result = sb.toString();
        return result;
    }
    public complex det(){
        if (n==m){
            int[] perm = new int[n];
            for (int i=0;i<n;i++){
                perm[i]=i;
            }
            return dett(matr, perm,0, n);
        }
        else{
            throw new IllegalArgumentException("Error. This is not square matrix");
        }
    }
    private static complex dett(complex[][] mat, int[] perm, int start, int nn) {

        if (start==nn) {
            complex value=new complex (1,0);
            for (int i=0;i<nn;i++) {
                value=value.multiply(mat[i][perm[i]]);
                for (int j=0;j<i;j++){
                    if (perm[j]>perm[i]){
                        double w1=-1*(value.getA());
                        double w2=-1*(value.getB());
                        value.setA(w1);
                        value.setB(w2);
                    }
                }
            }
            return value;
        }
        else {
            complex d = new complex(0, 0);
            for (int i = start; i < nn; i++) {
                swap(perm, start, i);
                complex z = dett(mat, perm, start + 1, nn);
                d = d.add(z);
                swap(perm, start, i);
            }
            return d;
        }
    }
    private static void swap (int[] perm, int i, int j){
        int k=perm[i];
        perm[i]=perm[j];
        perm[j]=k;
    }
    public matrix reverse(){
        complex determinant = this.det();
        matrix tr=this.transp();
        matrix ans=new matrix(n,m);
        int c=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                matrix minor = new matrix(n-1,m-1);
                int i2=0;
                int j2=0;
                for (int i1=0;i1<n;i1++){
                    for (int j1=0;j1<m;j1++){
                        if (i1!=i && j1!=j){
                            minor.setMatr(i2,j2,tr.getMatr(i1,j1));
                            j2+=1;
                            if (j2==n-1){
                                i2+=1;
                                j2=0;
                            }
                        }
                    }
                }
                complex value = minor.det();
                if (c%2!=0){
                    double v1=value.getA();
                    double v2=value.getB();
                    value.setA(-1*v1);
                    value.setB(-1*v2);
                }
                c+=1;
                value=value.div(determinant);
                ans.setMatr(i,j,value);
            }
        }
        return ans;
    }
    public matrix divv(matrix mat){
        mat=mat.reverse();
        matrix mat2=new matrix (this.n,this.m);
        for (int i=0;i<this.n;i++){
            for (int j =0;j<this.m;j++){
                mat2.setMatr(i,j,matr[i][j]);
            }
        }
        return mat.multiplication(mat2);
    }

}
