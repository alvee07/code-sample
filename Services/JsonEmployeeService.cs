using System;
using System.Collections.Generic;
using System.IO;
using System.Text.Json;
using Microsoft.AspNetCore.Hosting;
using web_api.Models;

namespace web_api.Services
{
    public class JsonEmployeeService
    {
        public IWebHostEnvironment WebHostEnvironment { get; }

        public JsonEmployeeService(IWebHostEnvironment webHostEnvironment)
        {
            WebHostEnvironment = webHostEnvironment;
        }


        private string JsonFileName
        {
            get { return Path.Combine(WebHostEnvironment.ContentRootPath, "Database", "dummy_employee.json"); }
        }

        public IEnumerable<Employee> GetEmployees()
        {
            using var jsonFileReader = File.OpenText(JsonFileName);
            return JsonSerializer.Deserialize<Employee[]>(jsonFileReader.ReadToEnd(),
                new JsonSerializerOptions
                {
                    PropertyNameCaseInsensitive = true
                });
        }
    }
}
