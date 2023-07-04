# Usar la imagen base de Node.js
FROM node:lts-alpine

RUN npm install -g http-server

# Establecer el directorio de trabajo en /app
RUN mkdir /app

WORKDIR /app

# Copiar el archivo package.json y package-lock.json
COPY package*.json ./

# Instalar las dependencias del proyecto
RUN npm install

# Copiar el resto de los archivos del proyecto
COPY . .

# Compilar la aplicación para producción
RUN npm run build

# Exponer el puerto 8080
EXPOSE 8080

CMD ["http-server","dist"]
