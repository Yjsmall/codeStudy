#coding=utf-8
import matplotlib.pyplot as plt
import matplotlib as mpl
import numpy as np

# 这是一个注释
print("你好世界")
x = np.linspace(0, 20, 100)  
plt.plot(x, np.sin(x))       
plt.show()                   