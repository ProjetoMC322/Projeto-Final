#####################################################
# MC102 - Algoritmos e Programação de Computadores
# Laboratório 14 - Plataforma
# Nome:
# RA:
#####################################################

"""
Esta função recebe como parâmetro uma lista que representa o tamanho do salto 
que pode ser dado em cada ponto de uma plataforma. Além disso, uma posição inicial 
na plataforma é determinada pelo parâmetro i. O retorno esperado para a função é 
um valor booleano, com True indicando que foi possível sair da plataforma e False 
indicando que o personagem ficou preso na plataforma (loop).
"""

def salto(plataforma, i, visitados):
    if i in visitados:
        return False
    if i - plataforma[i] < 0:
        return True
    if i + plataforma[i] > len(plataforma):
        return True
    if plataforma[i] == 0:
        return False
    visitados.append(i)
    for j in range(1, plataforma[i]+1):
        if(salto(plataforma, i+j, visitados)):
            return True
        if(salto(plataforma, i-j, visitados)):
            return True
    return False

# Leitura dos dados
plat = input().split(' ')
platInt = []
for i in plat:
    platInt.append(int(i))
initial = int(input())
if(salto(platInt, initial-1, [])):
    print("Saiu da plataforma")
else:
    print("Loop")
