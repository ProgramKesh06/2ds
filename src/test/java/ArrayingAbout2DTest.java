import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import org.junit.jupiter.api.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
class ArrayingAbout2DTest {
    private static int[][] testNumbersSingles;
    private static int[][] testNumbersSinglesNegs;
    private static int[][] testNumbersSinglesNotEven;
    private static int[][] testNumbersDoubles;
    private static int[][] testNumbersDoublesNegs;
    private static int[][] testNumbersDoublesNotEven;

    private static final double PRECISION = 0.00001;

    @BeforeAll
    static void setUp() {
        testNumbersSingles = new int[][]{
                {1,2,3,6},
                {7,3,2,4},
                {9,8,1,3},
                {3,6,7,5}
        };

        testNumbersSinglesNegs = new int[][]{
                {-4,-2,-5,-6},
                {-7,-1,-8,-4},
                {-9,-6,-7,-3},
                {-2,-8,-1,-5}
        };

        testNumbersSinglesNotEven = new int[][]{
                {1,2,3,6},
                {8,3},
                {9,8,1,3,6,5},
                {3,4,7}
        };

        testNumbersDoubles = new int[][]{
                {16,21,34,69},
                {70,39,22,46},
                {91,86,11,30},
                {33,64,76,51}
        };

        testNumbersDoublesNegs = new int[][]{
                {-14,-25,-38,-61},
                {-73,-42,-22,-49},
                {-93,-81,-10,-36},
                {-37,-62,-79,-55}
        };

        testNumbersDoublesNotEven = new int[][]{
                {14,25,51},
                {70,32,23,46,72,90},
                {96},
                {39,63,72,54,45}
        };
    }

    private static Stream<Arguments> providedNumbers_allMeans() {
        return Stream.of(
                Arguments.of(testNumbersSingles, 4.375),
                Arguments.of(testNumbersSinglesNegs, -4.875),
                Arguments.of(testNumbersSinglesNotEven, 4.6),
                Arguments.of(testNumbersDoubles, 47.4375),
                Arguments.of(testNumbersDoublesNegs, -48.5625),
                Arguments.of(testNumbersDoublesNotEven, 52.8)
        );
    }

    @DisplayName("Mean value of an array")
    @ParameterizedTest
    @MethodSource("providedNumbers_allMeans")
    void mean_variousArrays_allValid_returnsMean (int[][] arr, double mean) {
        double calcMean = ArrayingAbout2D.mean(arr);
        assertEquals(mean,calcMean,PRECISION);
    }

    private static Stream<Arguments> providedNumbers_allSums() {
        return Stream.of(
                Arguments.of(testNumbersSingles, 95.75),
                Arguments.of(testNumbersSinglesNegs, 99.75),
                Arguments.of(testNumbersSinglesNotEven, 95.6),
                Arguments.of(testNumbersDoubles, 9889.9375),
                Arguments.of(testNumbersDoublesNegs, 9315.9375),
                Arguments.of(testNumbersDoublesNotEven, 8288.4)
        );
    }

    @DisplayName("Sum of Squares values of an array")
    @ParameterizedTest
    @MethodSource("providedNumbers_allSums")
    void sums_variousArrays_allValid_returnsSums (int[][] arr, double sum) {
        double calcSum = ArrayingAbout2D.sum(arr);
        assertEquals(sum,calcSum,PRECISION);
    }

    private static Stream<Arguments> providedNumbers_allVariance() {
        return Stream.of(
                Arguments.of(testNumbersSingles, 5.984375),
                Arguments.of(testNumbersSinglesNegs, 6.234375),
                Arguments.of(testNumbersSinglesNotEven, 6.3733333),
                Arguments.of(testNumbersDoubles, 618.12109),
                Arguments.of(testNumbersDoublesNegs, 582.24609),
                Arguments.of(testNumbersDoublesNotEven, 552.56)
        );
    }

    @DisplayName("Variance values of an array")
    @ParameterizedTest
    @MethodSource("providedNumbers_allVariance")
    void variance_variousArrays_allValid_returnsVariance (int[][] arr, double variance) {
        double calcVar = ArrayingAbout2D.variance(arr);
        assertEquals(variance,calcVar,PRECISION);
    }

    private static Stream<Arguments> providedNumbers_allStandardDev() {
        return Stream.of(
                Arguments.of(testNumbersSingles, 2.4462982),
                Arguments.of(testNumbersSinglesNegs, 2.496873),
                Arguments.of(testNumbersSinglesNotEven, 2.5245462),
                Arguments.of(testNumbersDoubles, 24.862041),
                Arguments.of(testNumbersDoublesNegs, 24.129776),
                Arguments.of(testNumbersDoublesNotEven, 23.506595)
        );
    }

    @DisplayName("Standard dev values of an array")
    @ParameterizedTest
    @MethodSource("providedNumbers_allStandardDev")
    void standardDev_variousArrays_allValid_returnsStandardDev (int[][] arr, double standardDev) {
        double calcStandardDev = ArrayingAbout2D.standardDev(arr);
        assertEquals(standardDev,calcStandardDev,PRECISION);
    }


}