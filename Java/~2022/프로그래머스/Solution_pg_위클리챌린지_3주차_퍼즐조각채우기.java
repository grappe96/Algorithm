package study;

import java.util.*;

public class Solution_pg_위클리챌린지_3주차_퍼즐조각채우기 {
	static class Range {
		int startY, startX, endY, endX, size, r, c;
		public Range(int startY, int startX, int endY, int endX, int size) {
			this.startY = startY;
			this.startX = startX;
			this.endY = endY;
			this.endX = endX;
			this.size = size;
			this.r = endY-startY+1;
			this.c = endX-startX+1;
		}
	}
    static int n, dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1};
    public static int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        List<Range> hole = new ArrayList<Range>();
        List<Range> puzzle = new ArrayList<Range>();
        hole = bfs(game_board, 0);
        puzzle = bfs(table, 1);
        int answer = 0, hSize = hole.size(), pSize = puzzle.size();
        for(int i=0;i<hSize;i++) {
        	Range a = hole.get(i);
        	int[][] aBlock = returnBlock(a, game_board, 0);
        	for(int j=0;j<pSize;j++) {
        		Range b = puzzle.get(j);
        		if(b.size == 0)
        			continue;
        		int[][] bBlock = returnBlock(b, table, 1);
        		if(isSame(aBlock, bBlock) || rotate(aBlock, bBlock)) {
        			answer += a.size;
        			puzzle.set(j, new Range(-1,-1,-1,-1,0));
        			break;
        		}
        	}
        }
        return answer;
    }
    private static List<Range> bfs(int[][] board, int type) {
        List<Range> result = new ArrayList<Range>();
        int[][] copy = new int[n][n];
        for(int i=0;i<n;i++)
        	copy[i] = board[i].clone();
        
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(type==0 && copy[i][j] == 1)
        			continue;
        		if(type==1 && copy[i][j] == 0)
        			continue;
        		if(type==0)
        			copy[i][j] = 1;
        		else
        			copy[i][j] = 0;
        		int minY = n, minX = n, maxY = -1, maxX = -1, size = 0;
        		Queue<int[]> queue = new LinkedList<int[]>();
        		queue.add(new int[] {i,j});
        		while(!queue.isEmpty()) {
        			int[] now = queue.poll();
        			size++;
        			minY = Math.min(minY, now[0]);
        			minX = Math.min(minX, now[1]);
        			maxY = Math.max(maxY, now[0]);
        			maxX = Math.max(maxX, now[1]);
        			for(int d=0;d<4;d++){
        				int nr = now[0] + dr[d];
        				int nc = now[1] + dc[d];
        				
        				if(type==0) {
        					if(nr<0||nc<0||nr>=n||nc>=n||copy[nr][nc]==1)
        						continue;
        					copy[nr][nc] = 1;
        				}else {
        					if(nr<0||nc<0||nr>=n||nc>=n||copy[nr][nc]==0)
        						continue;
        					copy[nr][nc] = 0;
        				}
        				queue.add(new int[] {nr, nc});
        			}
        		}
        		result.add(new Range(minY, minX, maxY, maxX, size));
        	}
        }
        return result;
    }
    private static int[][] returnBlock(Range r, int[][] board, int type) {
    	int[][] block = new int[r.r][r.c];
    	for(int i=r.startY;i<=r.endY;i++) {
    		for(int j=r.startX;j<=r.endX;j++) {
    			if(type == 0)
    				block[i-r.startY][j-r.startX] = board[i][j]==0 ? 1 : 0;
    			else
    				block[i-r.startY][j-r.startX] = board[i][j];
    		}
    	}
    	return block;
    }
    private static boolean rotate(int[][] hole, int[][] puzzle) {
    	int r = puzzle.length, c = puzzle[0].length, rotated[][]=puzzle, result[][];
    	for(int d=0;d<3;d++) {
    		if(d%2==0) {
    			result = new int[c][r];
    			for(int i=r-1;i>=0;i--)
        			for(int j=0;j<c;j++)
        				result[j][r-1-i] = rotated[i][j];
    		}else {
    			result = new int[r][c];
	    		for(int i=c-1;i>=0;i--)
	    			for(int j=0;j<r;j++)
	    				result[j][c-1-i] = rotated[i][j];
    		}
    		rotated = result;
    		if(isSame(hole, result))
    			return true;
    	}
        return false;
    }
    private static boolean isSame(int[][] hole, int[][] puzzle) {
    	int r = hole.length, c = hole[0].length, pR = puzzle.length, pC = puzzle[0].length;
    	if(r!=pR || c!=pC)
    		return false;
    	for(int i=0;i<r;i++)
    		for(int j=0;j<c;j++)
    			if(hole[i][j] != puzzle[i][j])
    				return false;
        return true;
    }
}