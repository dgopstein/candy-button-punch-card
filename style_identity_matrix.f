C  MAKE V AN IDENTITY MATRIX
      PROGRAM MAIN
      DIMENSION V(10,10)
      N =9 
      DO 14 I = 1,N
         DO 12 J = 1,N
   12      V(I,J) = 0.0
   14    V(I,I) = 1.0
      END
