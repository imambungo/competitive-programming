class Solution {
    public boolean canCross(int[] stones) {
        boolean[][] sudah = new boolean[1100][100];
        boolean[][] result = new boolean[1100][100];
        return kodok(stones, 0, 1, sudah, result);
    }
    
    public boolean kodok(int[] stones, int posisi, int lompatan, boolean[][] sudah, boolean[][] result)
    {
        if (posisi < 1100 && lompatan < 100) {
            if (sudah[posisi][lompatan])
                return result[posisi][lompatan];
        }
        
        //System.out.println("posisi kodok = " + posisi + " (batu unit ke-" + stones[posisi] + ")");
        if (posisi == stones.length-1) {
            //System.out.println("batu terakhir cuy");
            return true;
        }

        //if (posisi >= stones.length)
            //return false;
        
        for (int i = lompatan-1; i <= lompatan+1; ++i)
        {
            if (i == 0)
                continue;
            
            if (posisi == 0 && i != 1)
                continue;
            
            //System.out.println("coba lompat " + i + " unit");
            int posisiSetelahMelompat = posisiSetelahMelompat(stones, posisi, i);
            
            if (posisiSetelahMelompat > 0) {
                //System.out.println("bisa melompat ke batu unit " + stones[posisiSetelahMelompat]);
                //System.out.println("posisi setelah melompat = " + posisiSetelahMelompat);
                if (kodok(stones, posisiSetelahMelompat, i, sudah, result)) {
                    if (posisi < 1100 && lompatan < 100) {
                        result[posisi][lompatan] = true;
                        sudah[posisi][lompatan] = true;
                    }
                    return true;
                }
            }
        }
        
        if (posisi < 1100 && lompatan < 100) {
            result[posisi][lompatan] = false;
            sudah[posisi][lompatan] = true;
        }
        return false;
    }
    
    public int posisiSetelahMelompat(int[] stones, int posisiSekarang, int lompatan)
    {
        //System.out.println("lompat " + lompatan + " unit dari unit ke-" + stones[posisiSekarang]);
        for (int i = posisiSekarang + 1; i < stones.length; ++i)
        {
            //System.out.println("index = " + i);
            if (lompatan < stones[i]-stones[i-1]) {
                //System.out.println("nyemplung");
                return -1;
            }
            
            lompatan -= (stones[i]-stones[i-1]);
            //System.out.println("sisa jangkauan unit = " + lompatan);
            
            if (lompatan == 0)
                return i;
            
            if (i == stones.length-1)
                return -1;
        }
        
        return stones.length - 1;
    }
}
