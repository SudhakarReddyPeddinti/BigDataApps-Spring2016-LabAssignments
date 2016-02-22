#Code to plot K-Means cluster

#Code to plot K-median cluster

#Code to plot EM cluster
ImageData = read.csv("image.csv")
install.packages("EMCluster")
library(EMCluster)
Image_Data <- ImageData[,-1]
cluster <- starts.via.svd(Image_Data, nclass = 11, method = "em")
plotem(cluster, Image_Data)


#Code to plot HM cluster

