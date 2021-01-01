FROM node:latest as build-WebUI

WORKDIR /app
COPY package.json ./ 
RUN npm install
RUN npm install -g @angular/cli
COPY . .
RUN npm run build --prod


FROM amd64/nginx:1.18.0-alpine
COPY --from=build-WebUI /app/dist/WebUI /usr/share/nginx/html
EXPOSE 4200