import cv2 as cv
import numpy as np
import os

for l in os.listdir("C:\\Users\\felip\\MC322\\Projeto-Final\\Imagens"):
    if l.endswith("py") or l.endswith("illa.py"):
        continue
    print(l)
    img = cv.imread(l, cv.IMREAD_UNCHANGED)
    resized = cv.resize(img, [80,80], interpolation= cv.INTER_CUBIC)
    print(img[0][0])
    cv.imwrite(l, resized)