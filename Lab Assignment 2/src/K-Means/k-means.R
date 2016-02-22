library(MASS)
str(Boston)
attach(Boston)
dat=data.frame(crim,medv)
a= kmeans(dat,10)
cl$cluster
plot(crim, medv,col=a$cluster)
points(a$centers, pch=16)
