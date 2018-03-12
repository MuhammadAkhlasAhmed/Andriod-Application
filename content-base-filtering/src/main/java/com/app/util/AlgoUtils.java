package com.app.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.app.dto.FinalMovieDto;
import com.app.dto.MovieRecordDTO;
import com.app.model.Movie;

/**
 * The Class AlgoUtils.
 */
public class AlgoUtils {
	
	/** The runtime. */
	public static int runtime;

	/** The revenue. */
	public static BigInteger revenue;
	
	/** The rating. */
	public static double rating;
	
	/** The voteCount. */
	public static int voteCount;
	
	/** The popularity. */
	public static double popularity;
	
	/** The budget. */
	public static BigInteger budget;
	
	// they are used for normalize the value by using formula x-min(x)/max(x)-min(x)
	static BigInteger maxRevenue = new BigInteger("2787965087");
	static BigInteger minRevenue = new BigInteger("1000000");
	static BigInteger maxBudget = new BigInteger("380000000");
	static BigInteger minBudget = new BigInteger("1000000");
	static BigInteger valueBudget;
	static BigInteger valueRevenue;
	static double maxPopularity = 875.581305;
	static int maxVotecount = 13752;
	static int maxRuntime = 338;
	static double[][] xMatrix;
	static double[][] yMatrix;
	static double[] zMatrix = new double[6];
	static double[][] weights = new double[6][1];
	static double  finalEquation;
	static List<FinalMovieDto> listOfRecommendedMovie;
	
	/**
	 * The method that perform web matrix factorization technique.
	 */
	public static List<FinalMovieDto> WebMatrixFactorizationTechnique(List<MovieRecordDTO> historicalMoviesList, List<Movie>  listOfFirstFiveMovieObject) {
		// Web Matrix
		// (x^t * x)^-1 * x^t * y
		// y = W0+W1X1+W2X2.....WnXn;
		xMatrix = new double[historicalMoviesList.size() - 1][6];
		yMatrix = new double[historicalMoviesList.size() - 1][1];
		for (int i = 0; i < historicalMoviesList.size() - 1; i++) {
			for (int k = i; k <= i; k++) {
				zMatrix[0] = 1;
				zMatrix[1] = (double) historicalMoviesList.get(k).popularity/maxPopularity;
				zMatrix[2] = (double) historicalMoviesList.get(k).voteCount/maxVotecount;
				zMatrix[3] = (double) historicalMoviesList.get(k).runtime/maxRuntime;
				valueBudget = new BigInteger(historicalMoviesList.get(k).budget.toString());
				valueRevenue = new BigInteger(historicalMoviesList.get(k).revenue.toString());
				double d = valueBudget.doubleValue() / maxBudget.doubleValue();
				double d1 = valueRevenue.doubleValue() / maxRevenue.doubleValue();
				zMatrix[4] = (double) d;
				zMatrix[5] = (double) d1;
				yMatrix[i][0] = (double) historicalMoviesList.get(k).rating;
			}
				for (int j = 0; j < zMatrix.length; j++) {
				xMatrix[i][j] = zMatrix[j];
			}
		}
		 // Transpose Matrix
		 double[][] tranposeMatrix = transposeIntArray(xMatrix);
		
		 // Multilpy Matrix
		 double[][] multiplyMatrix = multiply(tranposeMatrix, xMatrix);
		
		 // Determinant
		 double determinant = determinant(multiplyMatrix, multiplyMatrix.length);
		 double a = 1/determinant;
		
		 // Inverse of a(cofactor)
		 double[][] cofactor = cofactor(multiplyMatrix, multiplyMatrix.length,
		 multiplyMatrix.length);
		
		 // Multipy
		 double[][] mul = multiply(cofactor, tranposeMatrix);
		 // Multiply by Y (multiply by deter)
		 double[][] mul2 = multiply(mul, yMatrix);
			for (int i = 0; i < mul2.length; i++) {
			    for (int j = 0; j < mul2[i].length; j++) {
			    weights[i][0]=roundOff((mul2[i][j])*a, 2);
			    }
			}
			List<Movie> list = listOfFirstFiveMovieObject;
			listOfRecommendedMovie = new ArrayList<FinalMovieDto>();
			for (Movie movie : list) {
				FinalMovieDto finalMovieDto = new FinalMovieDto();
				double popularity = movie.getPopularity()/maxPopularity;
				double votecount = movie.getVoteCount()/maxVotecount;
				double runtime = movie.getRuntime()/maxRuntime;
				BigInteger valueBudget = new BigInteger(movie.getBudget().toString());
				BigInteger valueRevenue = new BigInteger(movie.getRevenue().toString());
				double finalBudgetValue = valueBudget.doubleValue() / maxBudget.doubleValue();
				double finalRevenueValue = valueRevenue.doubleValue() / maxRevenue.doubleValue();
				finalEquation = roundOff((weights[0][0])+(weights[1][0]*popularity)+(weights[2][0]*votecount)+(weights[3][0]*runtime)+(weights[4][0]*finalBudgetValue)+(weights[5][0]*finalRevenueValue), 1);
				finalMovieDto.setName(movie.getName());
				finalMovieDto.setRating(finalEquation);
				finalMovieDto.setTagline(movie.getTagline());
				listOfRecommendedMovie.add(finalMovieDto);
			}
			return listOfRecommendedMovie;
	}

	/**
	 * The method that roundOff the values.
	 */
	public static double roundOff(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();
		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	/**
	 * The method that transpose matrix.
	 */
	public static double[][] transposeIntArray(double[][] a) {
		int m = a.length;
		int n = a[0].length;
		double[][] b = new double[n][m];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				b[j][i] = a[i][j];
		return b;
	}

	/**
	 * The method that multiply two matrix.
	 */
	public static double[][] multiply(double[][] a, double[][] b) {
		int m1 = a.length;
		double n1 = a[0].length;
		double m2 = b.length;
		int n2 = b[0].length;
		if (n1 != m2)
			throw new RuntimeException("Illegal matrix dimensions.");
		double[][] c = new double[m1][n2];
		for (int i = 0; i < m1; i++)
			for (int j = 0; j < n2; j++)
				for (int k = 0; k < n1; k++)
					c[i][j] += a[i][k] * b[k][j];
		return c;
	}

	/**
	 * The method that calculate determinant.
	 */
	public static double determinant(double A[][], int N) {
		double det = 0;
		if (N == 1) {
			det = A[0][0];
		} else if (N == 2) {
			det = A[0][0] * A[1][1] - A[1][0] * A[0][1];
		} else {
			det = 0;
			for (int j1 = 0; j1 < N; j1++) {
				double[][] m = new double[N - 1][];
				for (int k = 0; k < (N - 1); k++) {
					m[k] = new double[N - 1];
				}
					for (int i = 1; i < N; i++) {
					int j2 = 0;
						for (int j = 0; j < N; j++) {
						if (j == j1)
							continue;
						m[i - 1][j2] = A[i][j];
						j2++;
					}
				}
				det += Math.pow(-1.0, 1.0 + j1 + 1.0) * A[0][j1] * determinant(m, N - 1);
			}
		}
		return roundOff(det, 2);
	}

	/**
	 * The method that calculate cofactor.
	 */
	public static double[][] cofactor(double[][] matrix, int rows, int cols) {
		double[][] result = new double[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[i][j] = (Math.pow(-1, i + j) * determinant(removeRowCol(matrix, rows, cols, i, j),
						removeRowCol(matrix, rows, cols, i, j).length));
			}
		}
		return result;
	}

	/**
	 * The method that return array that remove row and column.
	 */
	public static double[][] removeRowCol(double[][] matrix, int rows, int cols, int row, int col) {
		double[][] result = new double[rows - 1][cols - 1];
		int k = 0, l = 0;
		for (int i = 0; i < rows; i++) {
			if (i == row)
				continue;
			for (int j = 0; j < cols; j++) {
				if (j == col)
					continue;
				result[l][k] = matrix[i][j];
				k = (k + 1) % (rows - 1);
				if (k == 0)
					l++;
			}
		}
		return result;
	}
}
