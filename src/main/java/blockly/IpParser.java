package blockly;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Map;
import java.util.Map;

import com.maxmind.geoip2.*;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.InsightsResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Postal;
import com.maxmind.geoip2.record.Subdivision;

import cronapi.CronapiMetaData;
import cronapi.ParamMetaData;
import cronapp.framework.api.Device;


/**
 * Obter Localização por IP ...
 *
 * @author Usuário de Teste
 * @version 1.0
 * @since 2021-07-16
 *
 */

@CronapiMetaData(categoryName = "IP")
public class IpParser {

	@CronapiMetaData(type = "function", name = "getLocation", description = "Obter Localização por IP")
	public static Map<String, Object> getLocation(@ParamMetaData(description = "ID da Conta: ID da da conta") int accountId, @ParamMetaData(description = "Licença: Licença da conta") String licenseKey, @ParamMetaData(description = "IP: Parameter description") String ip) throws Exception {
		
		try (WebServiceClient client = new WebServiceClient.Builder(accountId, licenseKey).host("geolite.info").build()) {
			InetAddress ipAddress = InetAddress.getByName(ip);

			// Do the lookup
			CityResponse response = client.city(ipAddress);

			Country country = response.getCountry();
			System.out.println(country.getIsoCode());            // 'US'
			System.out.println(country.getName());               // 'United States'
			System.out.println(country.getNames().get("zh-CN")); // '美国'

			Subdivision subdivision = response.getMostSpecificSubdivision();
			System.out.println(subdivision.getName());       // 'Minnesota'
			System.out.println(subdivision.getIsoCode());    // 'MN'

			City city = response.getCity();
			System.out.println(city.getName());       // 'Minneapolis'

			Postal postal = response.getPostal();
			System.out.println(postal.getCode());       // '55455'

			Location location = response.getLocation();
			System.out.println(location.getLatitude());        // 44.9733
			System.out.println(location.getLongitude());       // -93.2323

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("country", country);
			map.put("subdivision", subdivision);
			map.put("city", city);
			map.put("postal", postal);
			map.put("location", location);

			return map;
		}
	}

}