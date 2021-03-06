/*******************************************************************************
 * ArtGel - Artificial Intelligence Gel Analysis Tool
 * Copyright 2019 Hector A. Ruiz-Moreno, Cindy P. Ulloa-Guerrero, Jorge Duitama
 *
 * This file is part of ArtGel.
 *
 *     ArtGel is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     ArtGel is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with ArtGel.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package Geles;

import java.util.*;

/**
 * Stores information of detected bands
 * @author Cindy Ulloa, Hector Ruiz, Jorge Duitama
 */
public class Band {
	private int bandID;
	private int startRow;
	private int endRow;
	private int startColumn;
	private int endColumn;
	private int wellPosition = -1;
	private int alleleClusterPosition = -1;
	
	/**
	 * Creates a new band object with the given information
	 * @param startRow The initial row where the band signal starts
	 * @param endRow The row where the band signal ends
	 * @param startColumn The initial column where the band signal starts
	 * @param endColumn The row where the band signal ends
	 */
	public Band(int startRow, int endRow, int startColumn, int endColumn, int id) {
		this.startRow=startRow;
		this.endRow=endRow;
		this.startColumn=startColumn;
		this.endColumn=endColumn;
		this.bandID=id;
	}

	/**
	 * @return bandID The identifier of the band in the corresponding well
	 */
	public int getBandID(){
		return bandID;
	}
	/**
	 * @return the startRow
	 */
	public int getStartRow() {
		return startRow;
	}

	/**
	 * @return the endRow
	 */
	public int getEndRow() {
		return endRow;
	}

	/**
	 * @return the startColumn
	 */
	public int getStartColumn() {
		return startColumn;
	}

	/**
	 * @return the endColumn
	 */
	public int getEndColumn() {
		return endColumn;
	}

	/**
	 * @return bandHeight The height the given band occupies vertically on the well
	 */
	public int calculateBandHeight(){
		return endRow-startRow;
	}

	/**
	 * @return the wellPosition
	 */
	public int getWellPosition() {
		return wellPosition;
	}

	/**
	 * @param wellPosition the wellPosition to set
	 */
	public void setWellPosition(int wellPosition) {
		this.wellPosition = wellPosition;
	}

	/**
	 * @return the alleleClusterPosition
	 */
	public int getAlleleClusterPosition() {
		return alleleClusterPosition;
	}

	/**
	 * @param alleleClusterPosition the alleleClusterPosition to set
	 */
	public void setAlleleClusterPosition(int alleleClusterPosition) {
		this.alleleClusterPosition = alleleClusterPosition;
	}

	public static double [][] calculateEuclideanDistances(List<Band> bands) {
		int totalBands = bands.size();
		double [][] euclideanDistances = new double[totalBands][totalBands];
        
        for(int i=0;i<totalBands;i++){
        	Band b1 = bands.get(i);
        	euclideanDistances[i][i] = 0;
        	for(int j=i+1; j<totalBands;j++){
        		Band b2 = bands.get(j);
        		double distance=1000;
        		if(b1.getWellPosition()!=b2.getWellPosition()) {
        			double squareDifferenceSum = Math.pow(b1.getStartRow()-b2.getStartRow(), 2);
            		squareDifferenceSum+=Math.pow(b1.getEndRow()-b2.getEndRow(), 2);
            		distance=Math.sqrt(squareDifferenceSum);
        		}
        		
        		//System.out.println("CalculatedDistance("+i+","+j+"): "+ distance);
    			euclideanDistances[i][j]=distance;
    			euclideanDistances[j][i]=distance;		
        	}
        }
        return euclideanDistances;
	}
	
	public int getMiddleRow() {
		return startRow + (endRow-startRow)/2;
	}
	
	public int getMiddleColumn(){
		return startColumn + (endColumn-startColumn)/2;
	}
}
