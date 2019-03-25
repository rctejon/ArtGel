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

import java.util.ArrayList;
import java.util.List;

/**
 * Stores well information in a byte array
 * @author Cindy Ulloa, Hector Ruiz, Jorge Duitama
 */
public class Well {

	private int wellID;
	private int startRow;
	private int wellHeight;
	private int startCol;
	private int wellWidth;
	private String sampleId;
	
	private List<Band> bands = new ArrayList<>();

	
	/**
	 * Creates a new well object with the given information
	 * @param wellHeight Row distance between well signal start and signal end
	 * @param laneNumber Number of the lane corresponding to the well
	 * @param filename txt file with intensity values in each well
	 * @throws IOException 
	 */
	public Well(int startRow,int startCol, int height, int width, int wellID){
	
		this.startRow=startRow;
		this.startCol=startCol;
		this.wellID=wellID;
		wellHeight=height;
		wellWidth=width;
		sampleId = ""+wellID;
	}

	/**
	 * @return wellID The identifier of the well
	 */
	public int getWellID(){
		return wellID;
	}
	
	/**
	 * @return Column distance between well signal start and signal end
	 */
	public int getWellWidth(){
		return wellWidth;
	}
	
	/**
	 * @return Row distance between well signal start and signal end
	 */
	public int getWellHeight(){
		return wellHeight;
	}
	
	/**
	 * @return Row in image where well image starts
	 */
	public int getStartCol(){
		return startCol;
	}
	
	/**
	 * @return Column in image where well image starts
	 */
	public int getStartRow(){
		return startRow;
	}
	
	public void addBand(Band band) {
		bands.add(band);
	}
	/**
	 * @return nBands The number of bands in the well
	 */
	public int getNumberOfBands(){
		int n=bands.size();
		return n;
	}
	
	/**
	 * @return bands A list of the bands present in the well
	 */
	public List<Band> getBands(){
		return bands;
	}

	public void removeBand(Band selected) {
		bands.remove(selected);
	}

	/**
	 * @param sampleId the sampleId to set
	 */
	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
	}

	public String getSampleId() {
		return sampleId;
	}
}
